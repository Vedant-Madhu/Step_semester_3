package oop.week5;

class ExtendedAccessRuleEngine {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null)
            return "DENIED";
        String mod = fieldModifier.toLowerCase();
        String ctx = accessorContext.toUpperCase();

        switch (mod) {
            case "private":
                return ctx.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
            case "default":
                return (ctx.equals("SAME_CLASS") || ctx.equals("SAME_PACKAGE")) ? "ALLOWED" : "DENIED";
            case "protected":
                if (ctx.equals("SAME_CLASS") || ctx.equals("SAME_PACKAGE")
                        || ctx.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
                    return "ALLOWED";
                }
                return "DENIED";
            case "public":
                return "ALLOWED";
            default:
                return "DENIED";
        }
    }

    public static String describeContext(String accessorContext) {
        if (accessorContext == null || accessorContext.isEmpty())
            return "";
        String[] parts = accessorContext.toLowerCase().split("_");
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            if (!part.isEmpty()) {
                if (sb.length() > 0)
                    sb.append(" ");
                sb.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1));
            }
        }
        return sb.toString();
    }
}

public class PracticeP2_CrossPackageReach {
    public static void main(String[] args) {
        System.out.println(ExtendedAccessRuleEngine.classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println(
                ExtendedAccessRuleEngine.classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
        System.out.println(ExtendedAccessRuleEngine.describeContext("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }
}