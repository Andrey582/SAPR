#!/bin/zsh

set -euo pipefail

base_url="${1:-http://localhost:8080}"

assert_contains() {
  local body="$1"
  local expected="$2"

  if [[ "$body" != *"$expected"* ]]; then
    echo "Assertion failed: expected response to contain: $expected" >&2
    echo "Actual response: $body" >&2
    exit 1
  fi
}

echo "1. Reset workspace"
curl -sS -o /dev/null -X POST "$base_url/api/workspace/reset"

echo "2. Create source component"
source_response=$(curl -sS -X POST "$base_url/api/components" \
  -H "Content-Type: application/json" \
  -d '{"id":"R1","type":"RESISTOR","label":"R1","x":0,"y":0}')
assert_contains "$source_response" '"id":"R1"'

echo "3. Create target component"
target_response=$(curl -sS -X POST "$base_url/api/components" \
  -H "Content-Type: application/json" \
  -d '{"id":"C1","type":"CAPACITOR","label":"C1","x":10,"y":0}')
assert_contains "$target_response" '"id":"C1"'

echo "4. Create connection"
connection_response=$(curl -sS -X POST "$base_url/api/connections" \
  -H "Content-Type: application/json" \
  -d '{"id":"W1","sourceComponentId":"R1","targetComponentId":"C1","signalName":"SIG_MAIN"}')
assert_contains "$connection_response" '"id":"W1"'

echo "5. Get summary"
summary_response=$(curl -sS "$base_url/api/summary")
assert_contains "$summary_response" '"componentCount":2'
assert_contains "$summary_response" '"connectionCount":1'
assert_contains "$summary_response" '"isolatedComponentIds":[]'
assert_contains "$summary_response" '"invalidConnectionIds":[]'

echo "Functional scenario completed successfully."
