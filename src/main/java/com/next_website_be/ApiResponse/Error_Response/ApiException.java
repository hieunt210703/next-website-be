package com.next_website_be.ApiResponse.Error_Response;

public class ApiException {
    // Not found
    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

    // Bad request
    public static class BadRequestException extends RuntimeException {
        public BadRequestException(String message) {
            super(message);
        }
    }

    // Conflict
    public static class ConflictException extends RuntimeException {
        public ConflictException(String message) {
            super(message);
        }
    }

    // Unauthorized
    public static class UnauthorizedException extends RuntimeException {
        public UnauthorizedException(String message) {
            super(message);
        }
    }

    // Forbidden
    public static class ForbiddenException extends RuntimeException {
        public ForbiddenException(String message) {
            super(message);
        }
    }

    // Internal server
    public static class InternalServerException extends RuntimeException {
        public InternalServerException(String message) {
            super(message);
        }
    }

    // Already deleted
    public static class AlreadyDeletedException extends RuntimeException {
        public AlreadyDeletedException(String message) {
            super(message);
        }
    }
}
