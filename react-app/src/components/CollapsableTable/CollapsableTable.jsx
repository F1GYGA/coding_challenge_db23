import { Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from "@mui/material";
import Row from "../Row";


const CollapsableTable = ({rows}) => {
    return (
        <TableContainer component={Paper}>
            <Table aria-label="collapsible table">
                <TableHead>
                    <TableRow>
                        <TableCell>ISIN</TableCell>
                        <TableCell align="center">Maturity Date</TableCell>
                        <TableCell align="center">CUSIP</TableCell>
                        <TableCell align="center">Issuer</TableCell>
                        <TableCell />
                    </TableRow>
                </TableHead>
                <TableBody>
                    {rows.map((row) => (
                        <Row key={row.name} row={row} />
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}

export default CollapsableTable;