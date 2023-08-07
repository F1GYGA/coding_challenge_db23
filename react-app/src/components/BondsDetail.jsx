import * as React from 'react';
import CollapsableTable from './CollapsableTable/CollapsableTable';

const BondsDetail = (props) => {
    return <CollapsableTable rows={props.info} date={props.date}/>
}

export default BondsDetail;