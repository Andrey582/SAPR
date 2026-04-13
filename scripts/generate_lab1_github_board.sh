#!/usr/bin/env bash

set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
SOURCE_CSV="$ROOT_DIR/board/lab1_github_board.csv"
OUTPUT_DIR="$ROOT_DIR/build/lab1-board"
SNAPSHOT_MD="$OUTPUT_DIR/lab1_github_board_snapshot.md"
REPORT_MD="$ROOT_DIR/docs/lab1_github_actions_board_report.md"

mkdir -p "$OUTPUT_DIR"
cp "$SOURCE_CSV" "$OUTPUT_DIR/"
cp "$REPORT_MD" "$OUTPUT_DIR/"

write_status_section() {
  local status="$1"
  echo "## $status" >> "$SNAPSHOT_MD"
  echo >> "$SNAPSHOT_MD"
  echo "| Issue | Summary | Type | Priority | Story Points | Sprint | Assignee | Due Date |" >> "$SNAPSHOT_MD"
  echo "|---|---|---|---|---:|---|---|---|" >> "$SNAPSHOT_MD"

  awk -F',' -v current_status="$status" '
    NR > 1 && $8 == current_status {
      due_date = $10 == "" ? "-" : $10
      printf("| %s | %s | %s | %s | %s | %s | %s | %s |\n", $1, $2, $3, $4, $5, $6, $7, due_date)
    }
  ' "$SOURCE_CSV" >> "$SNAPSHOT_MD"

  echo >> "$SNAPSHOT_MD"
}

{
  echo "# Lab 1 GitHub Board"
  echo
  echo "Проект: \`CAD-Schemes\`"
  echo
  echo "Источник данных: \`board/lab1_github_board.csv\`"
  echo
  echo "Workflow автоматически формирует снимок доски и публикует его как artifact \`lab1-github-board\`."
  echo
} > "$SNAPSHOT_MD"

write_status_section "Backlog"
write_status_section "To Do"
write_status_section "In Progress"
write_status_section "Code Review"
write_status_section "Testing"
write_status_section "Done"
