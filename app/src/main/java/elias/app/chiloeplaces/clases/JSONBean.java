package elias.app.chiloeplaces.clases;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Elias on 17-01-15.
 */
public class JSONBean implements PropertyChangeListener {

    @JsonProperty
    protected String md5;

    protected JSONBean(){
        support.addPropertyChangeListener(this);
    }

    //<editor-fold desc="Property Change support">
    @JsonIgnore
    protected PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener){
        support.removePropertyChangeListener(listener);
    }
    //</editor-fold>


    @Override
    public void propertyChange(PropertyChangeEvent event) {
        procesarHashMD5();
    }

    private void procesarHashMD5() {

        HashFunction hf = Hashing.md5();
        HashCode code = hf.hashInt(hashCode());
        md5 = code.toString();
    }

    public String getMd5() { return md5; }
}
