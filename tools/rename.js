const fs = require("fs");
const path = require("path");
const process = require("child_process");

var jsFile = {
  source: "/Users/Ivonhoe/Workspace/LeetCode/javascript/src",
  dest: "/Users/Ivonhoe/Workspace/LeetCode/javascript/src/leetcode/editor/cn",
  suffix: ".js",
};

var javaFile = {
  source: "/Users/Ivonhoe/Workspace/LeetCode/java/src",
  dest: "/Users/Ivonhoe/Workspace/LeetCode/java/src/leetcode/editor/cn",
  suffix: ".java",
};

var sourceFilePaths = [jsFile, javaFile];
var questionsMap = new Map();

try {
  // read contents of the file
  const data = fs.readFileSync("all.json", "UTF-8");

  var jsonParsed = JSON.parse(data);
  for (index in jsonParsed) {
    var queustionId = jsonParsed[index].frontendQuestionId;
    var question = jsonParsed[index];
    questionsMap[queustionId] = toCamelCase(question.titleSlug);
  }
} catch (err) {
  console.error(err);
}

for (index in sourceFilePaths) {
  var sourcePath = sourceFilePaths[index].source;
  var fileList = fs.readdirSync(sourcePath);
  fileList.forEach((file) => {
    var filePath = path.join(sourcePath, file);
    if (!fs.statSync(filePath).isDirectory()) {
      var fileNameSplits = file.split(".");
      var fileId = fileNameSplits[0];
      var camelCaseFileName = questionsMap[fileId];
      if (camelCaseFileName == undefined) {
        // console.log("file id:" + fileId);
      } else {
        var destDir = sourceFilePaths[index].dest;
        var suffix = sourceFilePaths[index].suffix;
        var destFileName = fileId + "-" + camelCaseFileName + suffix;
        var destPath = path.join(destDir, destFileName);

        if (!fs.existsSync(destPath)) {
          var command = `mv ${filePath} ${destPath}`;
          process.exec(command, (error, stdout, stderr) => {
            if (!error) {
              // 成功
            } else {
              // 失败
              console.log("----error:"+error)
            }
          });
        }
        console.log("source:" + filePath + ",dest:" + destPath);
      }
    }
  });
}

function toCamelCase(name) {
  var words = name.split("-");
  var ans = "";
  for (index in words) {
    var word = words[index];
    var upperCase = word.charAt(0).toUpperCase();
    var lowCase = "";
    if (word.length > 1) {
      lowCase = word.substr(1, word.length - 1);
    }

    ans += upperCase + lowCase;
  }
  return ans;
}
