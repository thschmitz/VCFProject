import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeletarArquivo{
  public void deletarArquivo(String caminho){
    try{
			Path path = Paths.get(caminho);
			Files.deleteIfExists(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
  }
}