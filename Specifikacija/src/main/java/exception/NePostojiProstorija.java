package exception;

/**
 * Eksepsn koja se baca kada se pokusa obrisati prostorija koja ne postoji
 */
public class NePostojiProstorija extends Exception{
    public NePostojiProstorija(String message){
        super(message);
    }
}
