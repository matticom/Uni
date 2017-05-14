package aud.a04;

public interface Map<K, V> {
    /* Typ-Parameter:
     *  K - der Typ der Schluessel
     *  V - der Typ der Werte
     * 
     *  Hinweis: zum Vergleich der Schluessel wird die equals-Methode
     *  verwendet
     */

    /**
     * fuegt ein Schluessel-Wert-Paar in die Map ein
     * @param key der Schluessel
     * @param value der Wert
     * @return falls es schon einen Wert mit Schluessel key in der Map
     *   gab, wird der alte Wert entfernt und zurueckgegeben;
     *   sonst wird null zurueckgegeben
     */
	
    V put(K key, V value);
    
    
    /**
     * bestimmt den Wert zu einem Schluessel in der Map
     * @param key der Schluessel
     * @return den Wert zum Schluessel key, falls ein                 
     * entsprechendes Schluessel-Wert-Paar vorhanden ist;
     * null sonst
     */

    V get(K key);

   
    /**
     * entfernt ein Schluessel-Wert-Paar aus der Map
     * @param key der Schluessel
     * @return der Wert zu dem Schluessel, falls ein entsprechendes
     *  Schluessel-Wert-Paar vorhanden ist;
     *  null sonst
     */

    V remove(K key);
}
