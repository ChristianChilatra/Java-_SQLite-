package modelo.vo;

public class Requerimiento_1Vo{

    private String ciudad;
    private int promedio;
    private final int NUM_COLUM = 2;


    public Requerimiento_1Vo() {
    }


    public Requerimiento_1Vo(String ciudad, float promedio) {
        this.ciudad = ciudad;
        this.promedio = Math.round(promedio);
    }

    public String getCiudad() {
        return this.ciudad;
    }
    public int getNumColum() {
        return this.NUM_COLUM;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getPromedio() {
        return this.promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

}
