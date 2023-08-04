import { Box, Collapse, IconButton, TableCell, TableRow, Typography } from "@mui/material";
import React from "react";

const Row=({row}) =>{
    const [open, setOpen] = React.useState(false);

    return (
        <React.Fragment>
            <TableRow sx={{ '& > *': { borderBottom: 'unset' } }}>
                <TableCell component="th" scope="row">
                    {row.isin}
                </TableCell>
                <TableCell align='center'>{row.maturity}</TableCell>
                <TableCell align="center">{row.cusip}</TableCell>
                <TableCell align="center">{row.issuer_name}</TableCell>
                <TableCell>
                    <IconButton
                        aria-label="expand row"
                        size="small"
                        onClick={() => setOpen(!open)}
                    >
                        {open ? "Close Details" : "View Deatils"}
                    </IconButton>
                </TableCell>
            </TableRow>
            <TableRow>
                <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={6}>
                    <Collapse in={open} timeout="auto" unmountOnExit>
                        <Box sx={{ margin: 1 }}>
                            <Typography variant="h6" gutterBottom component="div">
                                Bond details
                            </Typography>
                            <div>
                                Currency: {row.currency}
                            </div>
                            <div>
                                Coupon Percent: {row.coupon_percent}
                            </div>
                            <div>
                                Face Value: {row.face_value}
                            </div>
                            <div>
                                Status: {row.status}
                            </div>
                            <div>
                                Type: {row.type}
                            </div>
                            <div>
                                Holder Name: {row.holder_name}
                            </div>
                        </Box>
                    </Collapse>
                </TableCell>
            </TableRow>
        </React.Fragment>
    );
}

export default Row;