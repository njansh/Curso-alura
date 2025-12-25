package br.com.nadson.desafiosc4.modelo;



    public class ValidadorCodigoReferencia {

        public static String validarCodigo(String codigo) {

            try {
                if (codigo == null || codigo.isEmpty()) {
                    return "Erro: nenhum código foi informado.";
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            codigo = codigo.trim();

            if (codigo.length() != 8) {
                return "Erro: o código deve ter exatamente 8 caracteres (ex: ABC-1234).";
            }

            String letras = codigo.substring(0, 3);
            if (!validarLetras(letras)) {
                return "Erro: os 3 primeiros caracteres devem ser letras maiúsculas (A-Z).";
            }

            if (!validarHifen(codigo.charAt(3))) {
                return "Erro: o 4º caractere deve ser um hífen (-).";
            }

            String numeros = codigo.substring(4);
            if (!validarNumeros(numeros)) {
                return "Erro: os últimos 4 caracteres devem ser números (0-9).";
            }

            return "VÁLIDO";
        }

        private static boolean validarLetras(String texto) {
            return texto.matches("[A-Z]{3}");
        }

        private static boolean validarHifen(char c) {
            return c == '-';
        }

        private static boolean validarNumeros(String texto) {
            return texto.matches("[0-9]{4}");
        }
    }

