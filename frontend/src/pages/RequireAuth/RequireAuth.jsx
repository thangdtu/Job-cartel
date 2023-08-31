import { useLocation, Navigate, Outlet } from "react-router-dom";
import React from 'react'
import useAuth from "../../hooks/useAuth";

export default function RequireAuth({ allowedRoles }) {
    const { auth } = useAuth();
    const location = useLocation();

    return (
        auth?.roles?.find(role => allowedRoles?.includes(role))
            ? <Outlet />
            : auth?.user
                ? <Navigate to="/unauthorized" state={{ from: location }} replace />
                : <Navigate to="/login" state={{ from: location }} replace />
    );
}
