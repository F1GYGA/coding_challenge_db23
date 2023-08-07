import { Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from "@mui/material";
import Row from "../Row";
import "react-datepicker/dist/react-datepicker.css";


const CollapsableTable = (props) => {
    return (
        <>
            <TableContainer component={Paper}>
                <Table aria-label="collapsible table">
                    <TableHead>
                        <TableRow>
                            <TableCell>ISIN</TableCell>
                            <TableCell align="center">Maturity Date</TableCell>
                            <TableCell align="center">CUSIP</TableCell>
                            <TableCell align="center">Issuer</TableCell>
                            {props.date != null && <TableCell align='center'>Attention</TableCell>}
                            <TableCell />
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {props.rows.map((row) => (
                            <Row key={row.name} row={row} day={props.date} />
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </>
    );
}

export default CollapsableTable;