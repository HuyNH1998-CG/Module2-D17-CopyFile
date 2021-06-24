import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    private static void copyFileUsingJava7(File source, File dest) throws IOException {
        Files.copy(source.toPath(),dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    private static void copyFileUsingStream(File source, File dest){
        InputStream is;
        OutputStream os;
        try{
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0){
                os.write(buffer,0,length);
            }
            is.close();
            os.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter source file:");
        String sourcePath = input.nextLine();
        System.out.println("Enter destination file:");
        String destPath = input.nextLine();
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            copyFileUsingJava7(sourceFile,destFile);
            copyFileUsingStream(sourceFile,destFile);
            System.out.println("Done");
        } catch (IOException ioe){
            System.out.println("Cant copy");
            System.out.println(ioe.getMessage());
        }

    }
}
