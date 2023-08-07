import * as React from 'react';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import axios from 'axios';
import { useState } from 'react';
import { Navigate } from 'react-router';


const defaultTheme = createTheme();

const LogIn = () => {

    const [isLoggedIn, setLoggedIn] = useState(false);

    const handleSubmit = async (event) => {
        event.preventDefault();
        const data = new FormData(event.currentTarget);
        const credentials = {
            username: data.get('name'),
            password: data.get('password')
        }
        console.log(credentials);

        try {
            const response = await axios.post('http://127.0.0.1:8080/login', credentials, {
                withCredentials: true,
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded"
                }
            });
            console.log(response);
            if (response.status === 200) {
                setLoggedIn(true);
            } else {
                console.log("logging failed");
            }
        } catch (error) {
            console.error("Error durring logging: ", error)
        }
    };

    if (isLoggedIn) {
        return <Navigate to="/bonds" />
    }

    return (
        <ThemeProvider theme={defaultTheme}>
            <Container component="main" maxWidth="xs">
                <CssBaseline />
                <Box
                    sx={{
                        marginTop: 8,
                        display: 'flex',
                        flexDirection: 'column',
                        alignItems: 'center',
                    }}
                >
                    <Typography component="h1" variant="h5">
                        Sign in
                    </Typography>
                    <Box component="form" onSubmit={handleSubmit} noValidate sx={{ mt: 1 }}>
                        <TextField
                            margin="normal"
                            required
                            fullWidth
                            id="name"
                            label="Name"
                            name="name"
                            autoComplete="namel"
                            autoFocus
                        />
                        <TextField
                            margin="normal"
                            required
                            fullWidth
                            name="password"
                            label="Password"
                            type="password"
                            id="password"
                            autoComplete="current-password"
                        />
                        <Button
                            type="submit"
                            fullWidth
                            variant="contained"
                            sx={{ mt: 3, mb: 2 }}
                        >
                            Sign In
                        </Button>
                    </Box>
                </Box>

            </Container>
        </ThemeProvider>
    );
}

export default LogIn;