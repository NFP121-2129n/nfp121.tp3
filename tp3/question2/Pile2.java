package question2;

import question1.PilePleineException;
import question1.PileVideException;
import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        this.stk = new Stack<Object>();
        if(taille <= 0){
            this.capacite = this.CAPACITE_PAR_DEFAUT;
        }
        else {
            this.capacite = taille;
        }  
    }

    // constructeur fourni
    public Pile2() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.stk.push(o);
    }

    public Object depiler() throws PileVideException {
        if (estVide()) throw new PileVideException();
        return this.stk.pop();
    }

    public Object sommet() throws PileVideException {
        if (estVide()) throw new PileVideException();
        return this.stk.peek();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return this.stk.isEmpty();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return this.stk.size() == this.capacite();
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        Object[] arr = this.stk.toArray();
        String s = "[";
        for(int i = arr.length - 1; i >= 0; i--){
            s += arr[i].toString();
            if(i > 0) s += ", ";
        }
        return s + "]";
    }

    public boolean equals(Object o) {
        if (o instanceof Pile2) {
            Pile2 tempPile = (Pile2) o;
           return this.capacite() == tempPile.capacite()
          && this.hashCode() == tempPile.hashCode();
        }
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        return this.stk.size();
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
        return this.capacite;
    }

} // Pile2.java
