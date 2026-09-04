package eu.senla.regoffice.models;

public record CreateAdminResponse(Data data, String requestId) {
    public record Data(String staffid) {}
}
