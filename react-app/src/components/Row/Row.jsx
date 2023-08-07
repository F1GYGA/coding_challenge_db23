import { Box, Collapse, IconButton, TableCell, TableRow, Typography } from "@mui/material";
import React from "react";
import {Button} from 'react-bootstrap'
import { changeStatus } from "../../services/service";
import { useNavigate } from "react-router";


const Row = (props) => {
    const [open, setOpen] = React.useState(false);
    const today = props.day.toISOString().slice(0, 10);
    
    const navigate = useNavigate();
    const sendISIN = (event) =>{
        event.preventDefault();
        console.log(props.row.isin);
        changeStatus(props.row.isin);
        navigate("/bonds");
    }


    return (

        <React.Fragment>
            <TableRow sx={{ '& > *': { borderBottom: 'unset' } }}>
                <TableCell component="th" scope="row">
                    {props.row.isin}
                </TableCell>
                <TableCell align='center'>{props.row.maturityDate}</TableCell>
                <TableCell align="center">{props.row.cusip}</TableCell>
                <TableCell align="center">{props.row.issuerName}</TableCell>
                {props.row.maturityDate === today
                && <TableCell align='center' sx={{color:'orange',}}>! due to mature today</TableCell>}
                {Date.parse(props.row.maturityDate) < Date.parse(today) && props.row.status === 'active'
                && <TableCell align='center' sx={{color:'red',}}>! post maturity and not redeemed yet</TableCell>}
                {Date.parse(props.row.maturityDate) > Date.parse(today)
                && <TableCell align='center'>- - -</TableCell>}
                {Date.parse(props.row.maturityDate) < Date.parse(today) && props.row.status !== 'active'
                && <TableCell align='center'>- - -</TableCell>}
                
                {Date.parse(props.row.maturityDate) <= Date.parse(today) && props.row.status === 'active'
                && <TableCell align='center'>
                        <Button variant="primary" type="submit" onClick={sendISIN}>Redeem</Button>
                    </TableCell>}
                {Date.parse(props.row.maturityDate) > Date.parse(today) && props.row.status === 'active'
                && <TableCell align='center'>Cannot redeem yet</TableCell>}
                {Date.parse(props.row.maturityDate) <= Date.parse(today) && props.row.status !== 'active'
                && <TableCell align='center'>Redeemed</TableCell>}

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
                                Currency: {props.row.bondCurrency}
                            </div>
                            <div>
                                Coupon Percent: {props.row.couponPercent}
                            </div>
                            <div>
                                Face Value: {props.row.faceValue}
                            </div>
                            <div>
                                Status: {props.row.status}
                            </div>
                            <div>
                                Type: {props.row.type}
                            </div>
                            <div>
                                Holder Name: {props.row.bondHolders.map(holder => holder.holderName).join(',')}

                            </div>
                        </Box>
                    </Collapse>
                </TableCell>
            </TableRow>
        </React.Fragment>

    );
}

export default Row;