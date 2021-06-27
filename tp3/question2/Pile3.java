package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;

    public Pile3() {
        this(0);
    }

    public Pile3(int taille) {
        if(taille <=0) this.v = new Vector<Object>(this.CAPACITE_PAR_DEFAUT);
        else this.v = new Vector<Object>(taille);
    }

    public void empiler(Object o) throws PilePleineException {
        if(estPleine()) throw new PilePleineException();
        this.v.add(o);
    }

    public Object depiler() throws PileVideException {
        if(estVide()) throw new PileVideException();
        return this.v.remove(this.v.size() - 1);
    }

    public Object sommet() throws PileVideException {
        if(estVide()) throw new PileVideException();
        return this.v.lastElement();
    }

    public int taille() {
        return this.v.size();
    }

    public int capacite() {
        return this.v.capacity();
    }

    public boolean estVide() {
        return this.v.isEmpty();
    }

    public boolean estPleine() {
        return this.v.size() == this.v.capacity();
    }

    public String toString() {
        Object[] arr = this.v.toArray();
        String s = "[";
        for(int i = arr.length - 1; i >= 0; i--){
            s += arr[i].toString();
            if(i > 0) s += ", ";
        }
        return s + "]";
    }

    public boolean equals(Object o) {
        if (o instanceof Pile3) {
            Pile3 tempPile = (Pile3) o;
            return this.capacite() == tempPile.capacite()
          && this.hashCode() == tempPile.hashCode();
        }
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
