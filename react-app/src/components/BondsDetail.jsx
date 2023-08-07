import * as React from 'react';
import CollapsibleTable from './CollapsableTable';

const BondsDetail = (props) => {
    return <CollapsibleTable rows={props.info} date={props.date}/>
}

export default BondsDetail;