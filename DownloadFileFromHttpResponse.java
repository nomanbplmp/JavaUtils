public class  DownloadFileFromHttpResponse { 
  public File execute(Response response) throws IOException {
      String filename = null;
      String contentDisposition = response.header("Content-Disposition");
      if (contentDisposition != null && !"".equals(contentDisposition)) {
        // Get filename from the Content-Disposition header.
        Pattern pattern = Pattern.compile("filename=['\"]?([^'\"\\s]+)['\"]?");
        Matcher matcher = pattern.matcher(contentDisposition);
        if (matcher.find()) {
          filename = sanitizeFilename(matcher.group(1));
        }
      }

      String prefix = null;
      String suffix = null;
      if (filename == null) {
        prefix = "download-";
        suffix = "";
      } else {
        int pos = filename.lastIndexOf(".");
        if (pos == -1) {
          prefix = filename + "-";
        } else {
          prefix = filename.substring(0, pos) + "-";
          suffix = filename.substring(pos);
        }
        // File.createTempFile requires the prefix to be at least three characters long
        if (prefix.length() < 3) prefix = "download-";
      }

      if (tempFolderPath == null) return File.createTempFile(prefix, suffix);
      else return File.createTempFile(prefix, suffix, new File(tempFolderPath));
    }
}
