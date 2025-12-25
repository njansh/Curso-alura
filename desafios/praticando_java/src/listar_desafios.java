import java.io.File;

public class listar_desafios {
    public static void main(String[] args) {
        File raiz = new File("src/br/com/nadson");
        if (!raiz.exists()) {
            System.out.println("Diretório não encontrado: " + raiz.getAbsolutePath());
            return;
        }

        System.out.println("=== LISTA DE CURSOS E DESAFIOS ===\n");

        File[] pastas = raiz.listFiles(File::isDirectory);
        if (pastas == null) return;

        for (File pasta : pastas) {
            if (pasta.getName().startsWith("desafiosc")) {
                System.out.println("Curso: " + pasta.getName());
                File[] subpastas = pasta.listFiles(File::isDirectory);

                if (subpastas != null) {
                    for (File sub : subpastas) {
                        System.out.println("  - " + sub.getName());
                    }
                }

                System.out.println();
            }
        }
    }
}
