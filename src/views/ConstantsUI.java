package views;

import java.awt.*;
import java.time.LocalDate;

public class ConstantsUI {
    public static final String WINDOW_TITLE = "COVID-19 ANALYZER";
    public static final String[] HEADERS_TABLE = {"ID", "Fecha de Admision", "Ciudad", "Departamento", "Atencion", "Edad",
            "Sexo", "Tipo", "Estado", "Pais de Origen", "FIS", "Fecha Diagnostico", "Fecha Recuperacion", "Recuperacion"};
    public static final String[] SEX_OPTIONS = {"M", "F"};
    public static final String[] TYPE_OPTIONS = {"Relacionado", "En Estudio", "Importado"};
    public static final String[] ATTENTION_OPTIONS = {"Casa", "Hospital", "Recuperado", "Fallecido"};
    public static final String EXIT = "Salir";
    public static final String IMPORT = "Importar";
    public static final String EXPORT = "Exportar";
    public static final String REFRESH = "Actualizar";
    public static final String ARCHIVE = "Archivo";
    public static final String REPORTS = "Reportes";
    public static final String REMOVE_PATIENT = "Eliminar";
    public static final String ADD_PATIENT = "Añadir Paciente";
    public static final String USER_AMOUNT = "Usuarios por tipo de conexion";
    public static final String USER_AVRG = "Promedio de facturacion por estrato";
    public static final String PATH_USER = System.getProperty("user.dir");
    public static final String PATH_ROBOTO_BLACK = PATH_USER + "/src/resources/fonts/Roboto-Black.ttf";
    public static final String PATH_ROBOTO_REGULAR = PATH_USER + "/src/resources/fonts/Roboto-Regular.ttf";
    public static final String PATH_ROBOTO_LIGHT = PATH_USER + "/src/resources/fonts/Roboto-Light.ttf";
    public static final String PATH_AWESEOME_BRAND = PATH_USER + "/src/resources/fonts/fa-brands-400.ttf";
    public static final String EXCEPTION_MSG_FONT_ERROR = "No se puede cargar la fuente";
    public static final String CREATE_PATIENT_TITLE = "Crear "+ "\n" +" Paciente";
    public static final String MESSAGE_EXIT_APP = "Salir de la aplicación";

    //Patient Creation
    public static final String CITY = "Ciudad";
    public static final String DEPARTMENT = "Departamento";
    public static final String ATTENTION = "Atención";
    public static final String AGE = "Edad";
    public static final String SEX = "Sexo";
    public static final String TYPE = "Tipo";
    public static final String STATUS = "Estado";
    public static final String COUNTRY_OF_ORIGIN = "Pais de Origen";
    public static final String ADMISSION_DATE = "Fecha de admision";
    public static final String RECOVERY_TYPE = "Tipo de Recuperacion";
    public static final String RECOVERY_DATE = "Fecha de Recuperacion";
    public static final String FIRTS_SYMPTOMS_DATE = "Primeros Sintomas";
    public static final String DIAGNOSTIC_DATE = "Fecha de Diagnostico";
    public static final String CANCEL = "Cancelar";
    public static final String CREATE = "Crear";

    //Reports
    public static final String REPORT_ONE = "Crear";
    public static final String REPORT_TWO = "Crear";
    public static final String REPORT_THREE = "Crear";
    public static final String REPORT_FOUR = "Crear";
    public static final String REPORT_FIVE = "Crear";
    public static final String REPORT_SIX = "Crear";
    public static final String REPORT_SEVEN = "Crear";
    public static final String REPORT_EIGHT = "Crear";
    public static final String REPORT_NINE = "Crear";
    public static final String REPORT_TEN = "Crear";

    //Colors
    public static Color MAIN_COLOR = Color.decode("#2196F3");
    public static Color TEXT_COLOR = Color.decode("#ffffff");
    public static Color TITLE_COLOR = Color.decode("#ffffff");
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
    public static String PATH_ADD_ICON = "/resources/imgs/addP.png";
    public static String PATH_DELETE_ICON = "/resources/imgs/delete.png";
    public static String PATH_REPORTS_ICON = "/resources/imgs/reports.png";
    public static String PATH_COLOMBIA_MAP = "/resources/imgs/colombiaMap.jpg";

}
