package py.edu.facitec.oscar.paises;

import android.content.Context;

public class PaisDao extends DBA<Pais>{
    public PaisDao(Context context) {
        init(context,Pais.class);
    }
}
