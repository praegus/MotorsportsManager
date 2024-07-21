import { expect, test } from 'vitest'
import {ErrorUtil} from '../../src/utils';

test('ErrorUtil should return the json from an error response', () => {
    const errorResponse = {
        response: {
            json: () => Promise.resolve({
                detail: 'clean error message',
                title: 'generic error message',
                errors: [
                    {
                        'field': 'name',
                        'error': 'too long'
                    }
                ]
            })
        }
    }

    ErrorUtil.retrieveErrorMessage(errorResponse, (json) => {
        expect(json.detail).toBe('clean error message')
        expect(json.errors[0].error).toBe('too long')
    });
});

test('ErrorUtil should return a clear message if nothing was received from the backend', () => {
    const errorResponse = {
    }

    ErrorUtil.retrieveErrorMessage(errorResponse, (json) => {
        expect(json.detail).toBe('No response from backend.')
    });
});