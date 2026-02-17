package FileReader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileTypeCounter {


    public static HashMap<String, Integer> countFileTypes(File file) {
        HashMap<String, Integer> result = new HashMap<>();

        if (file == null || !file.exists()) {
            return result;
        }

        // ⭐ 修复1: 只在处理文件时提取扩展名，并移到if内部
        if (file.isFile()) {
            // 提取扩展名
            String fileName = file.getName();
            int lastDotIndex = fileName.lastIndexOf('.');

            // 检查是否有有效的扩展名
            if (lastDotIndex != -1 && lastDotIndex != 0) {
                // ⭐ 修复2: substring(lastDotIndex + 1) 跳过点号
                String extension = fileName.substring(lastDotIndex + 1);
                result.put(extension, result.getOrDefault(extension, 0) + 1);
            }
            // 如果没有扩展名（lastDotIndex == -1），忽略该文件
        }

        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children == null) {
                return result;
            }

            for (var c : children) {
                // ⭐ 修复3: 保存递归返回值
                HashMap<String, Integer> childCounts = countFileTypes(c);

                // ⭐ 修复4: 合并结果到当前result中
                for (Map.Entry<String, Integer> entry : childCounts.entrySet()) {
                    String ext = entry.getKey();
                    int count = entry.getValue();
                    result.put(ext, result.getOrDefault(ext, 0) + count);
                }
            }
        }

        return result;
    }
}