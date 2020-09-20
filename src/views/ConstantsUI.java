package views;

import java.awt.*;
import java.time.LocalDate;

public class ConstantsUI {
    public static final String WINDOW_TITLE = "COVID-19 ANALYZER";
    public static final String[] HEADERS_TABLE = {"ID", "Fecha de Admision", "Ciudad", "Atencion", "Edad",
            "Sexo", "Tipo", "Estado", "Pais de Origen", "FIS", "Fecha Diagnostico", "Fecha Recuperacion", "Recuperacion"};
    private int ID;
    private LocalDate admissionDate;
    private String city;
    private String department;
    private String attention;
    private byte age;
    private String sex;
    private String type;
    private String status;
    private String countryOfOrigin;
    private LocalDate firstSymptomsDate;
    private LocalDate diagnosticDate;
    private LocalDate recoveryDate;
    private String recoveryType;

    public static final String EXIT = "Salir";
    public static final String IMPORT = "Importar";
    public static final String EXPORT = "Exportar";
    public static final String REFRESH = "Actualizar";
    public static final String ARCHIVE = "Archivo";
    public static final String REPORTS = "Reportes";
    public static final String USER_AMOUNT = "Usuarios por tipo de conexion";
    public static final String USER_AVRG = "Promedio de facturacion por estrato";
    public static final String COMMERCIAL = "Comercial";
    public static final String DOMESTIC = "Domestico";
    public static final String STRATUM_ONE = "Estrato 1";
    public static final String STRATUM_TWO = "Estrato 2";
    public static final String STRATUM_THREE = "Estrato 3";
    public static final String STRATUM_FOUR = "Estrato 4";
    public static final String STRATUM_FIVE = "Estrato 5";
    public static final String PATH_USER = System.getProperty("user.dir");
    public static final String PATH_ROBOTO_BLACK = PATH_USER + "/src/resources/fonts/Roboto-Black.ttf";
    public static final String PATH_ROBOTO_REGULAR = PATH_USER + "/src/resources/fonts/Roboto-Regular.ttf";
    public static final String PATH_ROBOTO_LIGHT = PATH_USER + "/src/resources/fonts/Roboto-Light.ttf";
    public static final String PATH_AWESEOME_BRAND = PATH_USER + "/src/resources/fonts/fa-brands-400.ttf";
    public static final String EXCEPTION_MSG_FONT_ERROR = "No se puede cargar la fuente";
    public static final String MESSAGE_EXIT_APP = "Salir de la aplicación";

    //Colors
    public static Color MAIN_COLOR = Color.decode("#2d2d2d");
    public static Color TEXT_COLOR = Color.decode("#F8F8FF");
    public static Color TABLE_BG_COLOR = Color.decode("#000000");
    public static Color TABLE_FG_COLOR = Color.decode("#ffffff");
    public static Color BUTTON_BG_COLOR = Color.decode("#ffffff");
    public static Color BUTTON_FG_COLOR = Color.decode("#5B6A76");
    public static Color RED_COLOR = Color.decode("#ff0000");
    public static Color BLUE_BG_COLOR = Color.decode("#2196F3");
    public static Color SELECTED_BG_COLOR = Color.decode("#b3b3b3");


    //Icons PATH
    public static String PATH_EXIT_ICON = "/resources/imgs/exit.png";
    public static String PATH_EXPORT_ICON = "/resources/imgs/export.png";
    public static String PATH_IMPORT_ICON = "/resources/imgs/import.png";
    public static String PATH_REFRESH_ICON = "/resources/imgs/refresh.png";
    public static String PATH_COLOMBIA_MAP = "/resources/imgs/colombiaMap.jpg";

}
