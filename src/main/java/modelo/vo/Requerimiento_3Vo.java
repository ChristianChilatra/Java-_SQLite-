package modelo.vo;

public class Requerimiento_3Vo {
    // Su código
    private String material;
    private int idProyecto;
    private final int NUM_COLUM = 2;

    public Requerimiento_3Vo() {
    }

    public Requerimiento_3Vo(String material, int idProyecto) {
        this.material = material;
        this.idProyecto = idProyecto;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getNumColum() {
        return this.NUM_COLUM;
    }

    public int getIdProyecto() {
        return this.idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

}
