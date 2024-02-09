package br.glacks.model.bike;

public enum TipoBike {
    
    ROAD_BIKE(1, "Road Bike"), 
    MOUNTAIN_BIKE(2, "Mountain Bike"), 
    HYBRID_BIKE(3, "Hybrid Bike"), 
    ELECTRIC_BIKE(4, "Electric Bike"), 
    FOLDING_BIKE(5, "Folding Bike"), 
    CITY_OR_CRUISER_BIKE(6, "City Or Cruiser Bike"), 
    TRIATHLON_BIKE(7, "Triathlon Bike"), 
    BMX_BIKE(8, "BMX Bike"), 
    CYCLOCROSS_BIKE(9, "Cyclocross Bike"), 
    TOURING_BIKE(10, "Touring Bike");

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
