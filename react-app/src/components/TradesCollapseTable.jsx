import { Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from "@mui/material";
import TradeDetails from './TradeDetails';


const TradesCollapseTable = (props) => {
    return (
        <TableContainer component={Paper}>
            <Table aria-label="collapsible table">
                <TableHead>
                    <TableRow>
                        <TableCell align="center">Type</TableCell>
                        <TableCell align="center">Bond ISIN</TableCell>
                        <TableCell align="center">Quantity</TableCell>
                        <TableCell align="center">Unit price</TableCell>
                        <TableCell align="center">Counterparty</TableCell>
                        <TableCell />
                    </TableRow>
                </TableHead>
                <TableBody>
                    {props.rows.map((row) => (
                        <TradeDetails row={row} counterparty={props.counterparty} />
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}

export default TradesCollapseTable;