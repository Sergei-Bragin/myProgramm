package programm.fileArchiver.command;

import programm.fileArchiver.ConsoleHelper;
import programm.fileArchiver.ZipFileManager;
import programm.fileArchiver.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Распаковка архива.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введите путь для распаковки:");
            Path destinationPath = Paths.get(ConsoleHelper.readString());
            zipFileManager.extractAll(destinationPath);

            ConsoleHelper.writeMessage("Архив был распакован.");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Неверный путь для распаковки.");
        }
    }
}