package Domini;

/**
 * Created by maikals on 06/01/15.
 */
public class Val {

    private int id;
    private String nomSubscripcio;

    public Val(int id, String nomSubscripcio) {
        this.id = id;
        this.nomSubscripcio = nomSubscripcio;
    }

    public int getId() {
        return id;
    }

    public String getNomSubscripcio() {
        return nomSubscripcio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomSubscripcio(String nomSubscripcio) {
        this.nomSubscripcio = nomSubscripcio;
    }
}
