// Desarrollado por: Jesus Eduardo Cornejo Clavel
package SchoolPOO.pck_Video;

import SchoolPOO.pck_Fecha.Fecha;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VideoApp {
    public static void main(String[] args) {
        ArrayList<Video> videos = new ArrayList<>();
        int op;

        do {
            op = mostrarMenu();

            switch (op) {
                case 1:
                    agregarVideo(videos);
                    break;
                case 2:
                    mostrarVideos(videos);
                    break;
                case 3:
                    buscarVideo(videos);
                    break;
                case 4:
                    eliminarVideo(videos);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Bye :) Lalo Cornejo");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
                    break;
            }
        } while (op != 5);
    }

    private static int mostrarMenu() {
        int op = 0;
        boolean datoValido = false;

        do {
            try {
                String input = JOptionPane.showInputDialog(null, "Menú de opes:\n" +
                        "1. Agregar un elemento\n" +
                        "2. Mostrar los elementos\n" +
                        "3. Buscar un elemento\n" +
                        "4. Eliminar un elemento\n" +
                        "5. Salir\n" +
                        "Seleccione una opción:");
                if (input == null || input.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar una opción válida.");
                    continue;
                }
                op = Integer.parseInt(input);
                datoValido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Dato inválido. Debe ingresar un número entero.");
            }
        } while (!datoValido);

        return op;
    }

    private static void agregarVideo(ArrayList<Video> videos) {
        boolean datoValido = false;
        Video nuevoVideo = new Video();

        do {
            try {
                String titulo = JOptionPane.showInputDialog(null, "Ingrese el título del video:");
                if (titulo == null || titulo.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un título válido.");
                    continue;
                }
                if (buscarVideo(videos, titulo) != null) {
                    JOptionPane.showMessageDialog(null, "Ya existe un video con ese título.");
                    continue;
                }
                nuevoVideo.setTitulo(titulo);

                String productor = JOptionPane.showInputDialog(null, "Ingrese el productor del video:");
                if (productor == null || productor.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un productor válido.");
                    continue;
                }
                nuevoVideo.setProductor(productor);

                String classification = JOptionPane.showInputDialog(null, "Ingrese la clasificación del video:");
                if (classification == null || classification.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar una clasificación válida.");
                    continue;
                }
                nuevoVideo.setClassification(classification);

                String genero = JOptionPane.showInputDialog(null, "Ingrese el género del video:");
                if (genero == null || genero.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un género válido.");
                    continue;
                }
                nuevoVideo.setGenero(genero);

                float duration = 0.0f;
                do {
                    try {
                        String durationStr = JOptionPane.showInputDialog(null, "Ingrese la duración del video:");
                        if (durationStr == null || durationStr.length() == 0) {
                            JOptionPane.showMessageDialog(null, "Debe ingresar una duración válida.");
                            continue;
                        }
                        duration = Float.parseFloat(durationStr);
                        if (duration <= 0) {
                            JOptionPane.showMessageDialog(null, "La duración debe ser mayor a 0.");
                        } else {
                            nuevoVideo.setDuration(duration);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Dato inválido. Debe ingresar un número.");
                    }
                } while (duration <= 0);

                String fechaEstreno = null;
                boolean fechaValida = false;

                do {
                    try {
                        int dia = Integer
                                .parseInt(JOptionPane.showInputDialog(null, "Ingrese el día de estreno del video:"));
                        int mes = Integer
                                .parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes de estreno del video:"));
                        int anio = Integer
                                .parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de estreno del video:"));
                        Fecha fecha = new Fecha(dia, mes, anio);
                        if (fecha.fechaCorrecta()) {
                            fechaEstreno = fecha.getFecha();
                            fechaValida = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Fecha de estreno inválida. Intente de nuevo.");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Dato inválido. Debe ingresar un número.");
                    }
                } while (!fechaValida);

                nuevoVideo.setFechaEstreno(fechaEstreno);

                datoValido = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error. Intente nuevamente.");
            }
        } while (!datoValido);

        videos.add(nuevoVideo);
        JOptionPane.showMessageDialog(null, "Video agregado exitosamente.");
    }

    private static void mostrarVideos(ArrayList<Video> videos) {
        if (videos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay videos registrados.");
            return;
        }

        String tabla = "Nombre\tProductor\tAño de publicación\n";
        tabla += "----------------------------------------------------\n";

        for (Video video : videos) {
            tabla += video.getTitulo() + "\t";
            tabla += video.getProductor() + "\t";
            tabla += video.getFechaEstreno();
        }

        JOptionPane.showMessageDialog(null, tabla);
    }

    private static Video buscarVideo(ArrayList<Video> videos, String titulo) {
        for (Video video : videos) {
            if (video.getTitulo().equals(titulo)) {
                return video;
            }
        }
        return null;
    }

    private static void buscarVideo(ArrayList<Video> videos) {
        String titulo = null;
        boolean datoValido = false;

        do {
            try {
                titulo = JOptionPane.showInputDialog(null, "Ingrese el título del video a buscar:");
                if (titulo == null || titulo.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un título válido.");
                    continue;
                }
                datoValido = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error. Intente nuevamente.");
            }
        } while (!datoValido);

        Video video = buscarVideo(videos, titulo);
        if (video != null) {
            String info = "Título: " + video.getTitulo() + "\n";
            info += "Productor: " + video.getProductor() + "\n";
            info += "Clasificación: " + video.getClassification() + "\n";
            info += "Género: " + video.getGenero() + "\n";
            info += "Duración: " + video.getDuration() + " minutos\n";
            info += "Fecha de estreno: " + video.getFechaEstreno();
            JOptionPane.showMessageDialog(null, info);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el video.");
        }
    }

    private static void eliminarVideo(ArrayList<Video> videos) {
        String titulo = null;
        boolean datoValido = false;

        do {
            try {
                titulo = JOptionPane.showInputDialog(null, "Ingrese el título del video a eliminar:");
                if (titulo == null || titulo.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un título válido.");
                    continue;
                }
                datoValido = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error. Intente nuevamente.");
            }
        } while (!datoValido);

        Video video = buscarVideo(videos, titulo);
        if (video != null) {
            videos.remove(video);
            JOptionPane.showMessageDialog(null, "Video eliminado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el video.");
        }
    }
}