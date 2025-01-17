package utils;

import java.io.FileInputStream;

import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

public class FileReader {

    public FileReader() {

    }

    public HashMap readYMLFile(String fileName, int node) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream(fileName);
        HashMap yamlMap = yaml.load(inputStream);
        return (HashMap) yamlMap.get(node);
    }

    public String readYMLFile(String fileName, String env, String info) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream(fileName);
        HashMap yamlMap = yaml.load(inputStream);
        HashMap configInfo = (HashMap) yamlMap.get(env);
        return configInfo.get(info).toString();
    }
}
