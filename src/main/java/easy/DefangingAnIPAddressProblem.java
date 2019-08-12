package easy;

public class DefangingAnIPAddressProblem {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < address.length(); index++) {
            sb.append('.' == address.charAt(index) ? "[.]" : Character.toString(address.charAt(index)));
        }
        return sb.toString();
    }

    public String defangIPaddrShortSolution(String address) {
        return address.replace(".", "[.]");
    }
}
