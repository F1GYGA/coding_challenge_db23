import { Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from "@mui/material";
import Row from "../Row";
import { useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

const CollapsableTable = ({rows}) => {
    const [date, setDate] = useState(new Date());
    return (
        <>
            <DatePicker selected={date} onChange={(startDate) => setDate(startDate)} />
            <TableContainer component={Paper}
            // 
            >
                <Table aria-label="collapsible table">
                    <TableHead>
                        <TableRow>
                            <TableCell>ISIN</TableCell>
                            <TableCell align="center">Maturity Date</TableCell>
                            <TableCell align="center">CUSIP</TableCell>
                            <TableCell align="center">Issuer</TableCell>
                            <TableCell />
                            <TableCell />
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {rows.map((row) => (
                            <Row key={row.name} row={row} day={date} />
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </>
    );
}

export default CollapsableTable;