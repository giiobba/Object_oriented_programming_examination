package org.example;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;

import java.util.*;
import java.util.stream.IntStream;

import org.example.AsciiArtRow;

public class AsciiArtTable {

  private AsciiArtRow header = null;
  private List<AsciiArtRow> rows = new ArrayList<>();
  private Map<Integer, Integer> columnsLength = new HashMap<>();

  public AsciiArtTable(String... headers) {
    header = new AsciiArtRow();
    Arrays.asList(headers).stream().forEach(h -> {
      header.addCell(h);
    });
  }

  public void addRow(AsciiArtRow row) {
    rows.add(row);
    IntStream.range(0, row.getCells().size()).forEach(i -> {
      Integer currentCellLength = row.getCells().get(i).length();
      if (columnsLength.get(i) == null || columnsLength.get(i) < currentCellLength) {
        columnsLength.put(i, currentCellLength);
      }
    });
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    String newLine = System.getProperty("line.separator");
    // Header
    sb.append("| ").append(Joiner.on(" | ").join(getCellsWithPadding(header))).append(" |");
    Integer lineLength = sb.length();
    sb.append(newLine).append(Strings.repeat("-", lineLength)).append(newLine);
    // Row
    rows.stream().forEach(r -> {
      sb.append("| ").append(Joiner.on(" | ").join(getCellsWithPadding(r))).append(" |");
      sb.append(newLine);
    });
    return sb.toString();
  }

  private List<String> getCellsWithPadding(AsciiArtRow r) {
    List<String> padded = new ArrayList<>();
    IntStream.range(0, r.getCells().size()).forEach(i -> {
      padded.add(String.format("%-" + (columnsLength.get(i) + 2) + "s", r.getCells().get(i)));
    });
    return padded;
  }

}
