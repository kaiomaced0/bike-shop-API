package br.glacks.model.bike;

public enum TipoBike {
    
    ROAD_BIKE(1, "vermelho"), 
    MOUNTAIN_BIKE(2, "vermelho"), 
    HYBRID_BIKE(3, "vermelho"), 
    ELECTRIC_BIKE(4, "vermelho"), 
    FOLDING_BIKE(5, "vermelho"), 
    CITY_OR_CRUISER_BIKE(6, "vermelho"), 
    TRIATHLON_BIKE(7, "vermelho"), 
    BMX_BIKE(8, "vermelho"), 
    CYCLOCROSS_BIKE(9, "vermelho"), 
    TOURING_BIKE(10, "vermelho");

    private int id;
    private String label;

    TipoBike(int id, String label){
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static TipoBike valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for(TipoBike tipobike : TipoBike.values()) {
            if (id.equals(tipobike.getId()))
                return tipobike;
        } 
        throw new IllegalArgumentException("Id inválido:" + id);
    }
    
}
