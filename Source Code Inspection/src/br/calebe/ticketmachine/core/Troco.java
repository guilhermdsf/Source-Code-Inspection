package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    protected PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        int count;

        count = valor / 100;
        papeisMoeda[5] = new PapelMoeda(100, count);

        count = (valor % 100) / 50;
        papeisMoeda[4] = new PapelMoeda(50, count);

        count = (valor % 50) / 20;
        papeisMoeda[3] = new PapelMoeda(20, count);

        count = (valor % 20) / 10;
        papeisMoeda[2] = new PapelMoeda(10, count);

        count = (valor % 10) / 5;
        papeisMoeda[1] = new PapelMoeda(5, count);

        count = (valor % 5) / 2;
        papeisMoeda[0] = new PapelMoeda(2, count);
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;
        private int currentIdx;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
            this.currentIdx = 5;
        }

        @Override
        public boolean hasNext() {
            return currentIdx >= 0 && troco.papeisMoeda[currentIdx] != null;
        }

        @Override
        public PapelMoeda next() {
            if (hasNext()) {
                return troco.papeisMoeda[currentIdx--];
            }
            return null;
        }

        @Override
        public void remove() {
            // Não implementado
        }
    }
}
