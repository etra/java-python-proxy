package main.tasks;

import com.google.type.DateTime;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Map;

public class PythonTask extends Thread {
    String taskResponse;

    @Override
    public void run() {
        try {
            executeCommand();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String createCommandFile() throws IOException {

        String source = "/Users/arturas/work/pydatabase";
        String venv = "/Users/arturas/work/pydatabase/.venv/bin/activate";
        String script = "execute";

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        File temp = File.createTempFile("jpp_"+timestamp.toInstant().toString(), ".sh");
        temp.setExecutable(true);
        temp.setReadable(true);

        temp.deleteOnExit();

        BufferedWriter out = new BufferedWriter(new FileWriter(temp));

        out.write("#!/bin/bash");
        out.write("\ncd " + source);
        out.write("\nsource  " + venv);
        out.write("\npython -m " + script);
        out.close();

        return temp.getAbsolutePath();
    }

    public void executeCommand() throws IOException, InterruptedException {

        String commandFile = createCommandFile();
        ProcessBuilder pb = new ProcessBuilder("/bin/bash", "-c", commandFile);
        Map<String, String> env = pb.environment();
        env.put("PYTHONUNBUFFERED", "YES");
        Process process = pb.start();
        BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        StringBuilder result = new StringBuilder();
        result.append("output:\n");
        String line = null;
        while ((line = output.readLine()) != null)
            result.append(line);
        result.append("error:\n");
        while ((line = error.readLine()) != null)
            result.append(line);
        process.waitFor();
        System.out.println("Exit value: ");
        System.out.println(process.exitValue());

        taskResponse = result.toString();
    }

    public String getTaskOutput() {
        return taskResponse;
    }
}
