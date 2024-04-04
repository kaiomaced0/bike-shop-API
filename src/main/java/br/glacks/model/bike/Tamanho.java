package br.glacks.model.bike;

public enum Tamanho {
    A4(1, "aro 4"),
    A5(2, "aro 5"),
    A8(3, "aro 8"),
    A12(4, "aro 12"),
    A16(5, "aro 16"),
    A18(6, "aro 18"),
    A20(7, "aro 20"),
    A22(8, "aro 22"),
    A24(9, "aro 24"),
    A26(10, "aro 26"),
    A27(11, "aro 27"),
    A27_5(12, "aro 27,5"),
    A28(13, "aro 28"),
    A29(14, "aro 29 "),
    A650B(15, "aro 650B"),
    A700C(16, "aro 700C"),
    A_OUTRO(17, "outros aros");

    private int id;
    private String label;

    Tamanho(int id, String label){
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Tamanho valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for(Tamanho tamanho : Tamanho.values()) {
            if (id.equals(tamanho.getId()))
                return tamanho;
        }
        throw new IllegalArgumentException("Id inválido:" + id);
    }
}