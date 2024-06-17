import UIKit

enum FileError: Error {
    case fileNotFound
    case unreadable
    case encodingFailed
}

func readFile(at path: String) throws -> String {
    // 检查文件路径是否为空
    guard !path.isEmpty else {
        throw FileError.fileNotFound
    }
    
    // 检查文件是否存在
    let fileManager = FileManager.default
    guard fileManager.fileExists(atPath: path) else {
        throw FileError.fileNotFound
    }
    
    // 尝试读取文件内容
    do {
        let fileContent = try String(contentsOfFile: path, encoding: .utf8)
        return fileContent
    } catch {
        // 捕获文件读取错误
        throw FileError.unreadable
    }
}

var filePath = ""  // 模拟一个空的文件路径
filePath = "ffddd"

do {
    let fileContent = try readFile(at: filePath)
    print("File content: \(fileContent)")
} catch FileError.fileNotFound {
    print("Error: File not found.")
} catch FileError.unreadable {
    print("Error: File is unreadable.")
} catch FileError.encodingFailed {
    print("Error: Failed to encode the file content.")
} catch {
    print("An unknown error occurred: \(error)")
}
print("-------------------------------")

// 忽略错误并返回nil，可以使用try?
let filePath1 = ""
let fileContent1 = try? readFile(at: filePath1)
print(fileContent1 != nil ? "File content: \(String(describing: fileContent1))" : "unknown")
print("File content: " + (fileContent1 ?? "unknown"))

// 如果确定不会有错误发生，可以使用try!，但这会在运行时错误发生时引发崩溃
//let filePath2 = "valid_path"
//let fileContent2 = try! readFile(at: filePath2)
//print("File content: \(fileContent2)")
print("-------------------------------")

func play(param: FileError) {
    print(param)
}
play(param: FileError.fileNotFound)
play(param: .fileNotFound)
