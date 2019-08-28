package py.edu.facitec.oscar.paises;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Pais {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(unique = true)
    private String name;
    @DatabaseField(columnName = "cod_pais",unique = true)
    private String code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
