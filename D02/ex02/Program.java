import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;



public class Program {
	public static void main(String[] args) {
		Path currentPath;
		if (args.length != 1) {
			System.err.println("Argument must be one and content path!");
			System.exit(1);
		}
		if (!args[0].startsWith("--current-folder=")) {
			System.err.println("Argument must be in format: \"--current-folder=...\"");
			System.exit(1);
		}
		String[] arg = args[0].split("=");
		if (arg.length != 2) {
			System.err.println("Argument must be in format: \"--current-folder=...\"");
			System.exit(1);
		}
		if (arg[1].equals("")) {
			System.err.println("The current folder is not entered!");
			System.exit(1);
		}
		//File curPath = new File(arg[1]);
		currentPath =Paths.get(arg[1]);
		if (Files.exists(currentPath)) {
			if (!Files.isDirectory(currentPath)) {
				currentPath = currentPath.getParent();
			}
		}
		else {
			currentPath = currentPath.getParent();
			if (!Files.exists(currentPath)) {
				System.err.println("The current folder is not entered!");
				System.exit(1);
			}
		}
		System.out.println(currentPath);

		//System.out.println("is exist = "+Files.exists(currentPath));
		//System.out.println("is exist = "+Files.exists(currentPath));
		//System.out.println("is dir = "+Files.isDirectory(currentPath));
		//System.out.println("is not exist = "+Files.notExists(currentPath));
		//System.out.println("is readable = "+Files.isReadable(currentPath));
		//System.out.println("is file = "+curPath.isFile());
		//Path root = testFilePath.getRoot();
		//System.out.println(root);
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("-> ");
			if (sc.hasNext()) {
				String str = sc.next();
				if (str.equals("exit")) {
					System.exit(0);
				}
				else if (str.equals("cd")) {
					System.out.println("cd command!");
				}
				else if (str.equals("ls")) {
					LS ls = new LS();
					ls.showFiles(currentPath.toString());
					//System.out.println("ls command!");
				}
				else if (str.equals("mv")) {
					System.out.println("mv command!");
				}
				else {
					System.out.println("Invalid command!");
				}
			}

		}
/*
		Path fileName = testFilePath.getFileName();
		System.out.println(fileName);

		Path parent = testFilePath.getParent();
		System.out.println(parent);

		Path root = testFilePath.getRoot();
		System.out.println(root);
		*/
	}
}
