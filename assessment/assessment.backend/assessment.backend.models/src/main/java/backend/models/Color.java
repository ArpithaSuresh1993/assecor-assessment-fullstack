package backend.models;

/**
 * Enum for colors
 */
public enum Color {
    UNDEFINED("Undefined"),
    BLUE("blau"),
    GREEN("grün"),
    VIOLET("violett"),
    RED("rot"),
    YELLOW("gelb"),
    TURQUOISE("türkis"),
    WHITE("wieß");

    private String colorText;

    Color(String aColorText) {
        this.colorText = aColorText;
    }

    public String getColor_text() {
        return colorText;
    }

    public void setColor_text(String aColorText) {
        colorText = aColorText;
    }

    public static String byOrdinal(int ordinal) {
        for (Color color : Color.values()) {
            if (ordinal == color.ordinal()) {
                return color.getColor_text();
            }
        }
        return "Undefined";
    }
}
