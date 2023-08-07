import { TableCell, TableRow } from "@mui/material";
import React from "react";

const TradeDetails=(props) =>{

    return (
        <React.Fragment>
            <TableRow sx={{ '& > *': { borderBottom: 'unset' } }}>
                <TableCell align='center'>{props.row.tradeType}</TableCell>
                <TableCell align="center">{props.row.bond.isin}</TableCell>
                <TableCell align="center">{props.row.quantity}</TableCell>
                <TableCell align="center">{props.row.unitPrice}</TableCell>
                <TableCell align="center">{props.counterparty}</TableCell>
            </TableRow>
        </React.Fragment>
    );
}

export default TradeDetails;