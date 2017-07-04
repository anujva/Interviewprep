package com.anuj;

public class Main {

  public static void main(String[] args) {
    // write your code here
    String tagName = getHeartBeatTagName("SNK-150.W0576-STATE");
    System.out.println(tagName);

    tagName = getHeartBeatTagName("GANTRY-3.A1193-OPER_RUNNING");
    System.out.println(tagName);

    tagName = getHeartBeatTagName("US-EAST-0.US-EAST-0-STATE");
    System.out.println(tagName);

    tagName = getHeartBeatTagName("LOWBAY-BROTJE-IPAC-8.A7917-STATE");
    System.out.println(tagName);
  }

  private static String getHeartBeatTagName(String tagName) {
    String splitTagName;
    if (tagName.endsWith("-STATE")) {
      splitTagName = tagName.split("-STATE")[0];
    } else if (tagName.endsWith("-OPER_RUNNING")) {
      splitTagName = tagName.split("-OPER_RUNNING")[0];
    } else {
      throw new UnrecognizedTagNameExtensionException("The tag names for time series end with unrecognized values, "
          + "only supported values are -STATE and -OPER_RUNNING");
    }

    return splitTagName + "-HB";
  }
}
