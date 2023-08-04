import { Box, Collapse, IconButton, TableCell, TableRow, Typography } from "@mui/material";
import React from "react";

const Row=({row}) =>{
    const [open, setOpen] = React.useState(false);

    return (
        <React.Fragment>
            <TableRow sx={{ '& > *': { borderBottom: 'unset' } }}>
                <TableCell>
                    <IconButton
                        aria-label="expand row"
                        size="small"
                        onClick={() => setOpen(!open)}
                    >
                        {open ? "View less" : "View more"}
                    </IconButton>
                </TableCell>
                <TableCell component="th" scope="row">
                    {row.isin}
                </TableCell>
                <TableCell align="center">{row.cusip}</TableCell>
                <TableCell align="center">{row.issuer_name}</TableCell>
            </TableRow>
            <TableRow>
                <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={6}>
                    <Collapse in={open} timeout="auto" unmountOnExit>
                        <Box sx={{ margin: 1 }}>
                            <Typography variant="h6" gutterBottom component="div">
                                Bonds details
                            </Typography>
                            <div>
                                Bond holder: 
                            </div>
                        </Box>
                    </Collapse>
                </TableCell>
            </TableRow>
        </React.Fragment>
    );
}

export default Row;