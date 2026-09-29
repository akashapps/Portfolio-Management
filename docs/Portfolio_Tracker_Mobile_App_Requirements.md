# Mobile Portfolio Tracker App — Requirements & User Story Document

**Source reference:** AKASH_CANADA.xlsx — Sheet "Stock"
**Purpose:** Translate the manually-maintained Excel stock portfolio tracker into a mobile application feature set.

---

## 1. Background / Context

The Excel sheet is a personal TSE (Toronto Stock Exchange)-focused stock portfolio tracker. For each stock, the owner manually records: the ticker, dividend yield, live/current price (pasted in manually), number of shares, total invested amount, a running log of every individual purchase ("lot") with date/qty/price, and a running gain/loss vs. current market price. Below the table there is a portfolio-level summary (total investment, cash, total value, profit/loss), a yearly dividend total, and a per-stock 5-year historical value snapshot (2015–2020). A separate calculation area computes an average dividend yield.

The mobile app should digitize this exact workflow so the user can maintain and view their portfolio from a phone instead of an Excel file.

---

## 2. Epics Overview

| # | Epic | Excel Source |
|---|---|---|
| E1 | Holdings / Watchlist Management | Cols A, I |
| E2 | Purchase Lot Tracking (Dollar-Cost-Averaging log) | Col V–AN ("BUYING HISTORY") |
| E3 | Live & Reference Price Tracking | Cols J, K, L |
| E4 | Gain / Loss Calculation | Cols M, Q, R, S |
| E5 | Dividend Yield Tracking | Cols C, D, E |
| E6 | Dividend Income Log & Rollups | Sheet2 + rows 37–41 |
| E7 | Portfolio Summary Dashboard | Rows 31–35 |
| E8 | Historical Yearly Valuation | Cols AQ–AV |
| E9 | Cash Balance Tracking | Row 33 |

---

## 3. Detailed User Stories

### Epic 1 — Holdings / Watchlist Management

**US-1.1**
> As a portfolio owner, I want to add a stock to my portfolio by its ticker symbol and company name, so that I can start tracking it.

Acceptance Criteria:
- User can enter/search a ticker (e.g. `TSE:AC`) and the app stores the associated company name (e.g. "AIR CANADA").
- Each holding is a distinct row/card in the portfolio list.
- Duplicate tickers are prevented or merged into the existing holding.

**US-1.2**
> As a user, I want to remove or archive a stock I no longer hold, so my active list stays relevant.

---

### Epic 2 — Purchase Lot Tracking (Buying History)

**US-2.1**
> As a user, I want to log every individual purchase of a stock (date, quantity, price paid) so that I can see my full cost-basis history, exactly like the `DDMMYY-qty-price` entries in the sheet (e.g. `180322-13-23.80`).

Acceptance Criteria:
- Each lot entry has: purchase date, number of shares, price per share.
- A stock can have unlimited lots (the sheet shows some stocks with 10+ lots, e.g. VET, ACB).
- Lots are stored individually, not just as an average.

**US-2.2**
> As a user, I want the app to automatically calculate total shares held and total amount invested for a stock by summing all its lots, so I don't have to add it up manually (replicates columns T "NO OF SHARE" and U "TOTAL AMOUNT").

**US-2.3**
> As a user, I want to view a chronological purchase history per stock, so I can review my buying pattern over time (dollar-cost averaging behavior visible in the sheet).

**US-2.4**
> As a user, I want to edit or delete a previously entered lot in case of a data entry error.

---

### Epic 3 — Live & Reference Price Tracking

**US-3.1**
> As a user, I want to see the current market price of each holding, so I know what it's worth today (column L "LIVE PRICE").

**US-3.2**
> As a user, I want the app to auto-fetch live prices from a market data source, so I don't have to manually paste prices in like the spreadsheet requires (columns J/K/L are currently manual/static in Excel).

**US-3.3**
> As a user, I want to see the price I originally recorded as "last trade"/reference price for comparison (column J "LAST TRADE").

---

### Epic 4 — Gain / Loss Calculation

**US-4.1**
> As a user, I want to see the % difference between my average buy price and the current live price per stock, so I know if I'm up or down on that position (column M "DIFF").

**US-4.2**
> As a user, I want to see the dollar gain/loss per stock, comparing "amount invested" vs. "current value at live price" (columns Q "BUY PRICE" total, R "CURRENT PRICE" total, S "DIFF" $).

Acceptance Criteria:
- Green/red (or up/down arrow) indicator for gain vs. loss.
- Values recalculate whenever a live price updates or a new lot is added.

**US-4.3**
> As a user, I want a portfolio-wide unrealized profit/loss figure combining all stocks, so I can see overall performance at a glance (row 35 "PROFIT OR LOSS").

---

### Epic 5 — Dividend Yield Tracking

**US-5.1**
> As a user, I want to see the dividend-per-share value and calculated dividend yield % for each stock I hold (columns C, D, E — dividend yield, computed yield, per-share dividend amount).

**US-5.2**
> As a user, I want the app to flag or filter stocks by dividend yield, so I can identify my best income-generating holdings.

---

### Epic 6 — Dividend Income Log & Rollups

**US-6.1**
> As a user, I want to log each dividend payment I receive (date, stock ticker, amount), so I can track dividend income over time — matching the "Sheet2" dividend log (date / name / amount received).

**US-6.2**
> As a user, I want dividends automatically summed into a monthly total, so I can see income by month (Sheet2's per-month "TOTAL" rows, e.g. December 2020 = $10.48).

**US-6.3**
> As a user, I want an annual dividend total across all months, so I can compare year-over-year dividend income (rows 37–41: 2020 = $2,530, 2021 = $5,500, 2022 in progress = $500).

**US-6.4**
> As a user, I want to see an average monthly dividend figure calculated from recent months, so I can forecast future income (the "FORMULA FOR AVERAGE" block in columns Z–AB).

---

### Epic 7 — Portfolio Summary Dashboard

**US-7.1**
> As a user, I want a single summary screen showing: Total Investment, Cash on hand, Total Equity + Cash, and overall Profit/Loss — so I get a one-glance financial snapshot (rows 31–35).

**US-7.2**
> As a user, I want the dashboard to show a "last updated" timestamp, mirroring the sheet's "UPDATE ON [date]" label, so I know how current the data is.

---

### Epic 8 — Historical Yearly Valuation

**US-8.1**
> As a user, I want to record/view a year-end snapshot value per stock for past years (the sheet shows 2015–2020 columns per ticker), so I can track how each position's value trended year over year.

**US-8.2**
> As a user, I want a chart showing portfolio value trend across years, built from these year-end snapshots.

---

### Epic 9 — Cash Balance Tracking

**US-9.1**
> As a user, I want to manually record my uninvested cash balance, so it's included in my total net worth calculation alongside my equity positions (row 33 "CASH").

---

## 4. Non-Functional / Supporting Requirements

- **Manual override:** Since the original sheet is fully manual, all auto-fetched values (live price) should remain user-editable in case of bad data.
- **Offline support:** Core data entry (lots, dividends, cash) should work offline and sync later, consistent with a personal-tracking use case.
- **Data export:** Ability to export the portfolio (holdings, lots, dividends) back to CSV/Excel, since the source of truth today is a spreadsheet.
- **Currency:** All figures in CAD by default (TSE-listed securities).
- **Error handling:** Replicate/replace the `#N/A` and `#DIV/0!` states seen in the sheet with clean empty/zero states rather than raw error strings.

---

## 5. Out of Scope (Not Present in Sheet, flagged for clarification)

- Automated trade execution / brokerage integration
- Tax lot accounting (ACB/adjusted cost base for CRA reporting)
- Multi-currency or non-TSE listings
- Multi-user/shared portfolios

---

## 6. Suggested Prioritization (MoSCoW)

| Priority | Features |
|---|---|
| **Must have** | E1 Holdings, E2 Lot tracking, E4 Gain/Loss, E7 Dashboard |
| **Should have** | E3 Live price fetch, E6 Dividend log & rollups, E9 Cash |
| **Could have** | E5 Dividend yield analytics, E8 Historical yearly chart |
| **Won't have (v1)** | CSV export, offline sync, brokerage integration |
