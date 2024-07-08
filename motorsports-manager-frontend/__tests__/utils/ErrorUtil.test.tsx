import { expect, test } from 'vitest'
import {ErrorUtil} from '../../src/utils';

test('ErrorUtil should return defaultMessage if available', () => {
    const errorResponse = {
        response: {
            json: () => Promise.resolve({
                detail: 'clean error message',
                title: 'generic error message'
            })
        }
    }

    ErrorUtil.retrieveErrorMessage(errorResponse, (err) => {
        expect(err).toBe('clean error message')
    });
});

test('ErrorUtil should return generic message if no clear message is available', () => {
    const errorResponse = {
        response: {
            json: () => Promise.resolve({
                title: 'generic error message'
            })
        }
    }

    ErrorUtil.retrieveErrorMessage(errorResponse, (err) => {
        expect(err).toBe('generic error message')
    });
});